/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.beans;

/**
 *
 * @author hatem
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent; 
import org.primefaces.model.UploadedFile;
import javax.faces.context.ExternalContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@ManagedBean
public class FileUploadView implements Serializable{
     
    private UploadedFile uploadedFile;
    //Primitives
    private static final int BUFFER_SIZE = 6124;    

    public byte[] buffer;
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
 
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
     
    public void upload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    String fileName = uploadedFile.getFileName();
    String contentType = uploadedFile.getContentType();
    this.buffer = uploadedFile.getContents();
    
        if(uploadedFile != null) {
        FacesMessage message = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
       
            ExternalContext extContext = 
                          FacesContext.getCurrentInstance().getExternalContext();
//            File result = new File("/Users/hatem/NetBeansProjects/TFAR/target/TFAR-2.0/files/" + event.getFile().getFileName());
            File result = new File("/Users/hatem/NetBeansProjects/TFAR/target/TFAR-2.0/files/temp.png");


                System.out.println(extContext.getRealPath
                         ("/Users/hatem/NetBeansProjects/TFAR/target/TFAR-2.0/files/" + event.getFile().getFileName()));

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(result);

                buffer = new byte[BUFFER_SIZE];

                int bulk;
                InputStream inputStream = event.getFile().getInputstream();
                while (true) {
                    bulk = inputStream.read(buffer);
                    if (bulk < 0) {
                        break;
                    }
                    fileOutputStream.write(buffer, 0, bulk);
                    fileOutputStream.flush();
                }

                fileOutputStream.close();
                inputStream.close();

                FacesMessage msg = 
                            new FacesMessage("File Description", "file name: " +
                            event.getFile().getFileName() + "<br/>file size: " + 
                            event.getFile().getSize() / 1024 + 
                            " Kb<br/>content type: " + 
                            event.getFile().getContentType() + 
                                    "<br/><br/>The file was uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } catch (IOException e) {
                e.printStackTrace();

                FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                               "The files were not uploaded!", "");
                FacesContext.getCurrentInstance().addMessage(null, error);
            }       
    }    
}


    
    

