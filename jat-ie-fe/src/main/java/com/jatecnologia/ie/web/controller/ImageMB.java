package com.jatecnologia.ie.web.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.util.Constants;

import com.jatecnologia.ie.web.util.ConstantsUtil;


@Named
@ApplicationScoped
public class ImageMB {
	 public StreamedContent getImage() throws IOException {
		    FacesContext context = FacesContext.getCurrentInstance();
		    DefaultStreamedContent content = new DefaultStreamedContent();
		    content.setContentType("image/jpg");
		    if (context.getRenderResponse()) {
		      return content;
		    }
		    else {
		      String name = context.getExternalContext().getRequestParameterMap()
		          .get("name");
		      content.setStream(new FileInputStream(System.getProperty(ConstantsUtil.PROPERTY_PATH_ASSETS) + name));
		      return content;
		    }
		  }
	 
}
