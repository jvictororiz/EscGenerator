package util;

import org.apache.poi.xwpf.usermodel.*;
import rest.entity.TypeValue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplaceDocx {

    public static XWPFDocument donwloadEscCompleted(List<TypeValue> keys) {
        try {
            InputStream resourceAsStream = ReplaceDocx.class.getResourceAsStream("/testeEsc.docx");
            XWPFDocument doc = new XWPFDocument(resourceAsStream);
            List<TypeValue> keysTable = getListFromKey(keys, TypeValue.TIPO_TABLE);
            List<TypeValue> keysText = getListFromKey(keys, TypeValue.TIPO_TEXT);

            replaceTextTypeText(doc, keysText);
            replaceTextTypeTable(doc, keysTable);
            return doc;


//            doc.write(new FileOutputStream("C:\\Users\\Administrador\\Desktop\\testeEscConlcuido.docx"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private static List<TypeValue> getListFromKey(List<TypeValue> keys, String key) {
        List<TypeValue> keysForKey = new ArrayList<>();
        for (TypeValue typeValue : keys) {
            if (typeValue.getKey().equals(key)) {
                keysForKey.add(typeValue);
            }
        }
        return keysForKey;
    }

    private static XWPFDocument replaceTextTypeTable(XWPFDocument doc, List<TypeValue> keys) {
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.toLowerCase().contains("key") && !keys.isEmpty() && keys.get(0).getKey().equals(TypeValue.TIPO_TABLE)) {
                                String value = keys.get(0).getValue();
                                if (value.contains("\n")) {
                                    String[] lines = value.split("\n");
                                    r.setText(lines[0], 0);
                                    for (int i = 1; i < lines.length; i++) {
                                        r.addBreak();
                                        r.setText(lines[i]);
                                    }
                                } else {
                                    r.setText(value, 0);
                                }

                                keys.remove(0);
                            }
                        }
                    }
                }
            }
        }
        return doc;
    }

    private static XWPFDocument replaceTextTypeText(XWPFDocument doc, List<TypeValue> keys) {
        for (IBodyElement pp : doc.getBodyElements()) {
            for (XWPFParagraph p : pp.getPart().getParagraphs()) {
                for (XWPFRun a : p.getRuns()) {
                    String text = a.getText(0);
                    if (text != null && text.toLowerCase().contains("key") && !keys.isEmpty() && keys.get(0).getKey().equals(TypeValue.TIPO_TEXT)) {
                        String value = keys.get(0).getValue();
                        if (value.contains("\n")) {
                            String[] lines = value.split("\n");
                            a.setText(lines[0], 0);
                            for (int i = 1; i < lines.length; i++) {
                                a.addBreak();
                                a.setText(lines[i]);
                            }
                        } else {
                            a.setText(value, 0);
                        }

                        keys.remove(0);
                    }
                }
            }
        }
        return doc;
    }

}