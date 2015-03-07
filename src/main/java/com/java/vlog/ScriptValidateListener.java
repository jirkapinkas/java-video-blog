package com.java.vlog;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * This moves javascript loading from HEAD to the end of BODY (without jquery
 * javascript, which must stay in HEAD). It's just a speed optimization.
 * 
 * @author Jiri
 *
 */
public class ScriptValidateListener implements SystemEventListener {

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		UIViewRoot root = (UIViewRoot) event.getSource();
		FacesContext ctx = FacesContext.getCurrentInstance();
		List<UIComponent> resources = root.getComponentResources(ctx, "HEAD");
		for (UIComponent r : resources) {
			String name = (String) r.getAttributes().get("name");
			if (name == null) {
				continue;
			}

			if (name.contains(".js") && !name.contains("jquery.js")) {
				root.removeComponentResource(ctx, r, "HEAD");
				root.addComponentResource(ctx, r, "BODY");
			}
		}
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof UIViewRoot);
	}
}