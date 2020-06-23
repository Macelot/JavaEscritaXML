import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StreamTokenizer;

public class Teste {

    public static void main (String[] agrs){
       try{
           String valor="Hello";
           String arquivo = "C:\\temp\\filexml.xml";

           DocumentBuilderFactory dbf  =DocumentBuilderFactory.newInstance();

           DocumentBuilder dc = dbf.newDocumentBuilder();

           Document d = dc.newDocument();

           //elemento raiz do XML
           Element raiz = d.createElement("Posts");
           d.appendChild(raiz);

           //elemento post
           Element post = d.createElement("post");
           raiz.appendChild(post);

           //definindo o atributo do post
           Attr attr =d.createAttribute("id");
           long currentTimeStamp=System.currentTimeMillis();
           attr.setValue("_"+currentTimeStamp);
           post.setAttributeNode(attr);

           //definindo valor da postagem na tag text
           Element textoRecebido=d.createElement("Text");
           textoRecebido.appendChild(d.createTextNode(valor));
           post.appendChild(textoRecebido);

           //construção do XML
           TransformerFactory tf = TransformerFactory.newInstance();
           Transformer t = tf.newTransformer();
           DOMSource domSource = new DOMSource(d);
           StreamResult streamResult = new StreamResult(new File(arquivo));

           //juntar o conteudo ao arquivo criado
           t.transform(domSource,streamResult);
           System.out.println("Criado");



       } catch (Exception e){
           e.printStackTrace();
           System.out.println("Diretório "+System.getProperty("user.dir"));
       }

    }

}
