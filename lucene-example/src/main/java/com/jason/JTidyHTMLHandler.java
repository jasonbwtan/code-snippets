//package com.jason;
//
////how to add a web page document to lucene from an arbitrary source
//public class JTidyHTMLHandler {
//
//    public org.apache.lucene.document.Document getDocument(InputStream is) throws DocumentHandlerException {
//        Tidy tidy = new Tidy();
//        tidy.setQuiet(true);
//        tidy.setShowWarnings(false);
//        org.w3c.dom.Document root = tidy.parseDOM(is, null);
//        Element rawDoc = root.getDocumentElement();
//
//        org.apache.lucene.document.Document doc =
//                new org.apache.lucene.document.Document();
//
//        String body = getBody(rawDoc);
//
//        if ((body != null) && (!body.equals(""))) {
//            doc.add(new Field("contents", body, Field.Store.NO, Field.Index.ANALYZED));
//        }
//
//        return doc;
//    }
//
//    protected String getTitle(Element rawDoc) {
//        if (rawDoc == null) {
//            return null;
//        }
//
//        String title = "";
//
//        NodeList children = rawDoc.getElementsByTagName("title");
//        if (children.getLength() > 0) {
//            Element titleElement = ((Element) children.item(0));
//            Text text = (Text) titleElement.getFirstChild();
//            if (text != null) {
//                title = text.getData();
//            }
//        }
//        return title;
//    }
//
//    protected String getBody(Element rawDoc) {
//        if (rawDoc == null) {
//            return null;
//        }
//
//        String body = "";
//        NodeList children = rawDoc.getElementsByTagName("body");
//        if (children.getLength() > 0) {
//            body = getText(children.item(0));
//        }
//        return body;
//    }
//
//    protected String getText(Node node) {
//        NodeList children = node.getChildNodes();
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < children.getLength(); i++) {
//            Node child = children.item(i);
//            switch (child.getNodeType()) {
//                case Node.ELEMENT_NODE:
//                    sb.append(getText(child));
//                    sb.append(" ");
//                    break;
//                case Node.TEXT_NODE:
//                    sb.append(((Text) child).getData());
//                    break;
//            }
//        }
//        return sb.toString();
//    }
//    
//    public static void main(String[] args) {
//    	URL url = new URL(htmlURLlocation);
//    	URLConnection connection = url.openConnection();
//    	InputStream stream = connection.getInputStream();
//    	
//    	//or
//    	//InputStream stream = new FileInputStream(new File (htmlFile));
//
//	}
//}