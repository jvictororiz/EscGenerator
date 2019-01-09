import rest.EscDto;
import util.ReplaceDocx;
import rest.entity.TypeValue;

import java.util.ArrayList;
import java.util.List;

public class TestGeneratorFile {
    public static void main(String[] args) {
        EscDto escDto = new EscDto();
        escDto.setTitle("Vai se fuder");
        escDto.setModule("Nome do modulo");
        escDto.setObjctive("Nome do objetivo");
        escDto.setConteudo("Joao victor aqui e o conteudo entao pode dizer exatamente o que esta acontecendo porque eu ja estou ficando preocupado com voce /n/n/n/n/n/n/n/naqui quebre a linha");

        List<TypeValue> keys = new ArrayList<>();
        keys.add(new TypeValue(escDto.getTitle()));
        keys.add(new TypeValue(escDto.getModule()));
        keys.add(new TypeValue(escDto.getObjctive()));
        keys.add(new TypeValue(TypeValue.TIPO_TEXT, escDto.getConteudo()));
        ReplaceDocx.donwloadEscCompleted(keys);
    }
}
