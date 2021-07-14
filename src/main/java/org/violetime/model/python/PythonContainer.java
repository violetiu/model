package org.violetime.model.python;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.violetime.model.core.ModelContainer;
import org.violetime.model.data.IArgsAssemble;
import org.violetime.model.data.IDataAssemble;
import org.violetime.model.report.IModelReport;
import org.violetime.model.report.ModelReport;
import org.violetime.model.report.ModelReportType;
import org.violetime.model.view.IModelMethodReturn;
import org.violetime.model.view.ModelMethodReturn;
import org.violetime.tool.JsonData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * python语言模型容器；集成需要重写assemble和achieve方法
 */
public class PythonContainer extends ModelContainer implements  IPythonContainer{
    private final  static Logger LOGGER= LogManager.getLogger(PythonContainer.class);

    @Override
    public IModelMethodReturn run() {
        Process proc;
        try {
            String command="python3 "+getCommand()+" "+assemble(this.iDataAssemble,this.iArgsAssemble);
            LOGGER.debug(command);
            proc = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            StringBuffer out = new StringBuffer();
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();
            proc.waitFor();
            LOGGER.debug(out);
           IModelReport iModelReport= achieve(out.toString());
           this.result=iModelReport;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ModelMethodReturn(true, JsonData.MessageCode.Success);
    }


    @Override
    public String assemble(IDataAssemble iDataAssemble, IArgsAssemble iArgsAssemble) {



        return "";
    }


    @Override
    public IModelReport achieve(String out) {
       ModelReport modelReport= new ModelReport();
        modelReport.setType(ModelReportType.Null);
        return modelReport;
    }
}
