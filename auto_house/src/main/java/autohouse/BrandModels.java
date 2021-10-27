package autohouse;

public class BrandModels {
    private int modelId;
    private String modelName;
    private int brandID;

    public BrandModels(){}

    public BrandModels(int modelId, String modelName, int brandID) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.brandID = brandID;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
}
