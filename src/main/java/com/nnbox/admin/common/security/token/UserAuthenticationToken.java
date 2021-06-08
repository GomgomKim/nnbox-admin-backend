package com.nnbox.admin.common.security.token;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.nnbox.admin.data.model.AdminUser;
import com.nnbox.admin.data.model.User;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UserAuthenticationToken extends AbstractAuthenticationToken {

	String id;
	String password;
	AdminUser adminUser;

	public UserAuthenticationToken(String id, String password, Collection<? extends GrantedAuthority> authorities, boolean authenticated) {
		super(authorities);
		super.setAuthenticated(authenticated);
		this.id = id;
		this.password = password;
	}

	@Override
	public Object getCredentials() {
		return password;
	}

	@Override
	public Object getPrincipal() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    User that = (User) obj;
	    return getPrincipal().equals(that.getId()) &&
	    		getCredentials().equals(that.getPassword());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(getCredentials(), getPrincipal());
	}


}
