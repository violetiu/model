package org.violetime.model.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModelConfigLoadder {
    private final  static Logger LOGGER= LogManager.getLogger(ModelConfigLoadder.class);
    private List<IModelConfigGroup> iModelConfigGroups;
    public List<IModelConfigGroup> getiModelConfigGroups(){
        return iModelConfigGroups;
    }
    public void load(String configFile,String path){
        LOGGER.info(configFile);
        File file = new File(configFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Node root = doc.getLastChild();
            for(int index=0;index<root.getChildNodes().getLength();index++){
                Node node =root.getChildNodes().item(index);
                if(node.getNodeName().equals("group")){
                    loadGroup(node,path);
                }

            }
            LOGGER.info("Loading Completed");
        }catch(Exception e){
            e.printStackTrace();

        }

    }
    private void loadGroup(Node node,String path){

        String label= node.getAttributes().getNamedItem("label").getTextContent();
        ModelConfigGroup modelConfigGroup=new ModelConfigGroup();
        modelConfigGroup.setLabel(label);
        List<IModelConfig> modelConfigs=new ArrayList<>();
        for(int index=0;index<node.getChildNodes().getLength();index++){
            Node child =node.getChildNodes().item(index);
            if(child.getNodeName().equals("model")){
                IModelConfig modelConfig= loadModel(child,path);
                modelConfigs.add(modelConfig);
            }

        }
        modelConfigGroup.setModels(modelConfigs);

        if(iModelConfigGroups==null)
            iModelConfigGroups=new ArrayList<>();
        iModelConfigGroups.add(modelConfigGroup);

    }
    private IModelConfig loadModel(Node node,String path){
       String name= node.getAttributes().getNamedItem("name").getTextContent();
       String container= node.getAttributes().getNamedItem("container").getTextContent();
       String command="";
       if(node.getAttributes().getNamedItem("command")!=null){
           command= node.getAttributes().getNamedItem("command").getTextContent();
       }
        String jar="";
        if(node.getAttributes().getNamedItem("jar")!=null){
            jar= node.getAttributes().getNamedItem("jar").getTextContent();
        }


       if(!command.startsWith("/")||command.indexOf(":")!=1){
        command=path+"/"+command;
       }

        if(!jar.startsWith("/")||jar.indexOf(":")!=1){
            jar=path+"/"+jar;
        }


       ModelConfig modelConfig=new ModelConfig();
       modelConfig.setCommand(command);
       modelConfig.setJar(jar);
       modelConfig.setContainer(container);
       modelConfig.setName(name);

        String image= node.getAttributes().getNamedItem("image").getTextContent();
        String text= node.getAttributes().getNamedItem("text").getTextContent();
        modelConfig.setImage(image);
        modelConfig.setText(text);
        boolean isStructure=false;
        Node isStructureNode=node.getAttributes().getNamedItem("isStructure");
        if(isStructureNode!=null){
            String isStructureString= isStructureNode.getTextContent();
            if(isStructureString!=null&&isStructureString.toLowerCase().equals("true")){
                isStructure=true;
            }
        }
        modelConfig.setStructure(isStructure);
        boolean isEnable=false;
        Node isEnableNode=node.getAttributes().getNamedItem("isEnable");
        if(isEnableNode!=null){
            String isEnableString=isEnableNode.getTextContent();
            if(isEnableString!=null&&isEnableString.toLowerCase().equals("true")){
                isEnable=true;
            }
        }
        modelConfig.setEnable(isEnable);
        return  modelConfig;
    }
}
