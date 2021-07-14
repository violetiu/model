package org.violetime.model.config;

import java.util.List;

public class ModelConfigGroup implements  IModelConfigGroup{
    private String label;
    private List<IModelConfig> models;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<IModelConfig> getModels() {
        return models;
    }

    public void setModels(List<IModelConfig> models) {
        this.models = models;
    }
}
