package com.pengzhen.bcm.common.utils;

import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

public class MyCommentGenerator implements CommentGenerator {

	public MyCommentGenerator() {
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
    }
	
	public void addJavaFileComment(CompilationUnit compilationunit)
    {
    }

    public void addComment(XmlElement xmlElement)
    {
        if(suppressAllComments)
            return;
        StringBuilder sb = new StringBuilder();
        sb.append("<!--@mbggenerated  由mybatis generated自动生成,请不要做任何操作-->");
        xmlElement.addElement(new TextElement(sb.toString()));
        String s = getDateString();
        if(s != null)
        {
            sb.setLength(0);
            sb.append(s);
            xmlElement.addElement(new TextElement(sb.toString()));
        }
    }

    public void addRootComment(XmlElement xmlelement)
    {
    }

    public void addConfigurationProperties(Properties properties)
    {
        this.properties.putAll(properties);
        suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));
        suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
    }

    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete)
    {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" *");
        sb.append("@mbggenerated");
        if(markAsDoNotDelete)
            sb.append(" 在合并期间请勿做删除操作");
        String s = getDateString();
        if(s != null)
        {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    protected String getDateString()
    {
        if(suppressDate)
            return null;
        else
            return (new Date()).toString();
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable)
    {
        return;
    }

    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable)
    {
       return;
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
    {
       return;
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable)
    {
        return;
    }

    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable)
    {
        return;
    }

    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
    {
        if(suppressAllComments)
        {
            return;
        } else
        {
            StringBuilder sb = new StringBuilder();
            method.addJavaDocLine("/**");
            sb.setLength(0);
            sb.append(" * @return ");
            sb.append(introspectedColumn.getActualColumnName());
            method.addJavaDocLine(sb.toString());
            addJavadocTag(method, false);
            method.addJavaDocLine(" */");
            return;
        }
    }

    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
    {
        if(suppressAllComments)
        {
            return;
        } else
        {
            StringBuilder sb = new StringBuilder();
            method.addJavaDocLine("/**");
            method.addJavaDocLine(" *");
            Parameter parm = (Parameter)method.getParameters().get(0);
            sb.setLength(0);
            sb.append(" * @param ");
            sb.append(parm.getName());
            method.addJavaDocLine(sb.toString());
            addJavadocTag(method, false);
            method.addJavaDocLine(" */");
            return;
        }
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete)
    {
         return;
    }
     private Properties properties;
	 private boolean suppressDate;
	 private boolean suppressAllComments;
    
}
