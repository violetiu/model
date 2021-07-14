package org.violetime.model.view;

import org.violetime.tool.JsonData;

/**
 * 模型类中方法返回
 */
public class ModelMethodReturn implements IModelMethodReturn {

    private boolean success;
    private JsonData.MessageCode message;


    public ModelMethodReturn(boolean success) {
        this.success = success;
    }
    public ModelMethodReturn(boolean success, JsonData.MessageCode message) {
        this.success = success;
        this.message=message;
    }
    @Override
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public JsonData.MessageCode getMessage() {
        return message;
    }

    public void setMessage(JsonData.MessageCode message) {
        this.message = message;
    }
}
