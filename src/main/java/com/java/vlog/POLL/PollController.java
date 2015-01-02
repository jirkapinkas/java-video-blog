package com.java.vlog.POLL;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;

import com.java.vlog.service.PollService;

@Named
@Scope("session")
public class PollController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PollService pollService;
	
	public boolean isNewUser() {
		return ! FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().containsKey("answered_poll_1");
	}

	public void save(int selectedValue) {
		pollService.save(selectedValue);
		saveCookie();
	}
	
	public void cancel() {
		saveCookie();
	}
	
	private void saveCookie() {
		HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		Cookie cookie = new Cookie("answered_poll_1", "true");
		cookie.setMaxAge(31536000); // 1 year
		response.addCookie(cookie);

	}

}
