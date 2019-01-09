package rest;

public class EscDto {
    private String title;
    private String module;
    private String objctive;
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getObjctive() {
        return objctive;
    }

    public void setObjctive(String objctive) {
        this.objctive = objctive;
    }
}
