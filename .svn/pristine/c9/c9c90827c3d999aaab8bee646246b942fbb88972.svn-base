package org.violetime.model.data;

import java.util.List;

public interface IModelArg  {

    public ModelArgType getType();
    public String getName() ;
    public String getLabel();

    /**
     * 多选的值 由空格分隔
     * @return
     */
    public Object getValue() ;
    public void setValue(Object value);
    public String getTest();
    public String getError();
    public List<ModelArgsOption> getOptions();
    public boolean isRequired();

    /**
     * 是否与模型参数有关，默认false
     * @return
     */
    public boolean isStructure();

    public int getKey() ;

    public void setKey(int key);
}
