package ru.javabegin.training.springwebflow.objects;

import java.io.Serializable;
import javax.validation.constraints.Size;

public class User implements Serializable {

  private static final long serialVersionUID = 7730377931313245319L;


  @Size(min = 3, message = "{name.size.error}")
  // Имя должно быть больше 6 знаков
  private String username;

  @Size(min = 3, max = 10, message = "{password.size.error}")
  private String password;


  public User() {
  }

  public User(String username) {
    this.username = username;
  }


  public User(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
    User other = (User) obj;
    if (username == null) {
			if (other.username != null) {
				return false;
			}
    } else if (!username.equals(other.username)) {
			return false;
		}
    if (password == null) {
			return other.password == null;
    } else
			return password.equals(other.password);
	}


}
