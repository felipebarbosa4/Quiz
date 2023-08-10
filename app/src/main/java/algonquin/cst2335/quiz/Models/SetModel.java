package algonquin.cst2335.quiz.Models;

/**
 * This class is used to store the set name and its category id
 * It is used to store the data in the database
 * It is used to retrieve the data from the database
 * It is used to display the data in the recycler view
 * It is used to display the data in the quiz activity
 * It is used to display the data in the quiz result activity
 * It is used to display the data in the quiz category activity
 * It is used to display the data in the quiz set activity
 * It is used to display the data in the quiz question activity
 * It is used to display the data in the quiz question result activity
 *
 * @Author: Felipe Barbosa Figueira
 */
public class SetModel {

    String setNmae;
    private int categoryId;

    public SetModel(String setNmae) {
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
