package org.violetime.model.data;

import java.util.List;
import java.util.Map;

public class ModelArg implements  IModelArg{
    public ModelArg() {
        this.required=false;
        this.structure=false;
    }

    private ModelArgType type;
    @Override
    public ModelArgType getType() {

        return this.type;
    }

    public void setType(ModelArgType type) {
        this.type = type;
    }

    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private String name;
    private String label;
    private Object value;
    private List<ModelArgsOption> options;
    private String test;
    private String error;
    private boolean required;
    private boolean structure;

    public boolean isStructure() {
        return structure;
    }

    public void setStructure(boolean structure) {
        this.structure = structure;
    }

    public String getTest() {
        return test;
    }

    /**
     * 设置检查正则
     * @param test
     */
    public void setTest(String test) {
        this.test = test;
    }

    public String getError() {
        return error;
    }

    /**
     * 设置错误提示代码，事先在多语言中设置好
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    public boolean isRequired() {
        return required;
    }
    /**
     * 设置是否必须
     * @param required
     */

    public void setRequired(boolean required) {
        this.required = required;
    }


    public List<ModelArgsOption> getOptions() {
        return options;
    }

    /**
     * 设置选项
     * @param options
     */
    public void setOptions(List<ModelArgsOption> options) {
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    /**
     *  需要在多语言设置中定义好
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
