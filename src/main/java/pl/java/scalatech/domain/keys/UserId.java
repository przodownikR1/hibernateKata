package pl.java.scalatech.domain.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserId implements Serializable {

    private static final long serialVersionUID = -126374349626177631L;

    protected String username;

    protected Long departmentId;



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId userId = (UserId) o;
        if (!departmentId.equals(userId.departmentId)) {
            return false;
        }
        if (!username.equals(userId.username)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + departmentId.hashCode();
        return result;
    }
}
