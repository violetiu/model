package org.violetime.model.python;

import org.violetime.model.core.IModelContainer;
import org.violetime.model.data.IArgsAssemble;
import org.violetime.model.data.IDataAssemble;
import org.violetime.model.report.IModelReport;

/**
 * python语言模型容器接口
 */
public interface IPythonContainer extends IModelContainer {
    /**
     * 装配数据到运行模型
     */
    public String assemble(IDataAssemble iDataAssemble, IArgsAssemble iArgsAssemble);

    /**
     * 组装返回结果
     */
    public IModelReport achieve(String out);
}
