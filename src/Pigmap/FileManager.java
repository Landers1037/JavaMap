package Pigmap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.awt.Color;
import java.io.File;

public class FileManager {
	public static String WorkingFile()
	{
		return working_file;
	}
	public static void Reset()
	{
		working_file = null;
	}
	private static String working_file;

	public static Tree Load(String path)
	{
		try {
			File fXmlFile = new File(path);
			if(!fXmlFile.exists())
				return null;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Tree ret = new Tree();
			TreeNode root=LoadSub(doc, doc.getFirstChild());
			ret.SetRoot(root);

			working_file = path;

			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static TreeNode LoadSub(Document doc, Node cur)
	{
		NamedNodeMap attr = cur.getAttributes();
		TreeNode ret = new TreeNode("");
		String name=attr.getNamedItem("Name").getTextContent();
		int x = Integer.parseInt(attr.getNamedItem("X").getTextContent());
		int y = Integer.parseInt(attr.getNamedItem("Y").getTextContent());
		int w = Integer.parseInt(attr.getNamedItem("W").getTextContent());
		int h = Integer.parseInt(attr.getNamedItem("H").getTextContent());
		Color c = Color.decode(attr.getNamedItem("Color").getTextContent().toUpperCase());
		ret.setText(name);
		ret.setLocation(x, y);
		ret.setSize(w, h);
		ret.SetColor(c);

		NodeList children = cur.getChildNodes();
		for(int i=0;i<children.getLength();i++)
			ret.AddChild(LoadSub(doc, children.item(i)), false);
		return ret;
	}

	public static void Save(Tree t, String path) {
		try {
			if(t==null || t.Root()==null)
				return;
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			SaveSub(document, document, t.Root());

			//
			DOMSource xmlDOM = new DOMSource(document);
			StreamResult xmlFile = new StreamResult(new File(path));
			TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void SaveSub(Document doc, Node parent, TreeNode node)
	{
		Element e = doc.createElement("Node");
		e.setAttribute("Name", node.getText()+"");
		e.setAttribute("X", node.getX()+"");
		e.setAttribute("Y", node.getY()+"");
		e.setAttribute("W", node.getWidth()+"");
		e.setAttribute("H", node.getHeight()+"");
		e.setAttribute("Color", "0x"+Integer.toHexString(node.Color().getRGB()).toString().substring(2));
		parent.appendChild(e);
		for(TreeNode child : node.Children())
			SaveSub(doc, e, child);
	}
}
