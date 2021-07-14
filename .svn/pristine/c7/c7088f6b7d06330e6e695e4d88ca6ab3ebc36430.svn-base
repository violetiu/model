package org.violetime.model.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 模型传输参数集合
 */
public class ArgsAssemble implements  IArgsAssemble {
    private  Map<String, Object> args;

    public void loadArgs(IModelArg[] iModelArgs){
        if(iModelArgs!=null){
            if(args==null)
                args=new HashMap<>();
            for(IModelArg iModelArg:iModelArgs){
                args.put(iModelArg.getName(),iModelArg.getValue());

            }
        }
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }

    @Override
    public Map<String, Object> getArgs() {
        return this.args;
    }
}
