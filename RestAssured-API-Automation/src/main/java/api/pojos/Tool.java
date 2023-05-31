package api.pojos;

public class Tool {
    String category;
    int results;
    boolean available;
    int toolId;
    boolean userManual;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    public boolean isUserManual() {
        return userManual;
    }

    public void setUserManual(boolean userManual) {
        this.userManual = userManual;
    }
}
