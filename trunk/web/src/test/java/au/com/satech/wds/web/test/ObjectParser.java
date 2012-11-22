/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.test;

/**
 *
 * @author wu
 */
import java.io.File; 
import java.io.IOException; 
 
import javax.xml.bind.JAXBContext; 
import javax.xml.bind.JAXBException; 
import javax.xml.bind.Marshaller; 
import javax.xml.bind.Unmarshaller; 
 
 
public class ObjectParser { 
    public ObjectParser(){ 

    } 

    static public Object openObject(File file){ 
            Object object = new Object(); 
            try { 
                    JAXBContext jaxbContext = JAXBContext.newInstance(Object.class); 

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
                    object = (Object)jaxbUnmarshaller.unmarshal(file); 
            } catch (JAXBException e) { 
                    e.printStackTrace(); 
            } 
            return object; 
    } 

    static public File saveObjectTOFile(Object object){ 
            File file = new File("projects\\"+object.getClass().getName()+".xml"); 
            try { 
                    file.createNewFile(); 
            } catch (IOException e1) { 
                    e1.printStackTrace(); 
            } 
            try { 
                    JAXBContext jaxbContext = JAXBContext.newInstance(Object.class); 
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); 
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
                    jaxbMarshaller.marshal(object, file); 
            } catch (JAXBException e) { 
                    e.printStackTrace(); 
            } 
            return file; 
    } 
} 

