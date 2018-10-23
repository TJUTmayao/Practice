package project.entity;

import java.io.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/10 15:44
 * @Description:
 */
public class UserLogin implements Externalizable {
    public UserLogin(){}

    private Integer userLoginId;

    private  String userAccount;

    private transient String userPassword;

    public Integer getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.getUserAccount());
        objectOutput.writeObject(this.getUserLoginId());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.userAccount = (String) objectInput.readObject();
        this.userLoginId = (Integer) objectInput.readObject();
    }

}
