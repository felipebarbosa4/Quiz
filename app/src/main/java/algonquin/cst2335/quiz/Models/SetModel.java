package algonquin.cst2335.quiz.Models;

public class SetModel {

    String setNmae;
    private int categoryId;

    public SetModel(String setNmae, int categoryId) {
        this.setNmae = setNmae;
        this.categoryId = categoryId;

    }

    public String getSetNmae() {
        return setNmae;
    }

    public void setSetNmae(String setName) {
        this.setNmae = setNmae;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }


}