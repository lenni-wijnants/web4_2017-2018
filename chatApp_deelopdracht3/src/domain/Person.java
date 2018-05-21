package domain;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String userId;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private Role role;
	private String status;
	private HashSet<Person> friendList;

	public Person(String userId, String password, String firstName,
			String lastName,Role role) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setStatus("Offline");

		friendList = new HashSet<Person>();
	}

	public Person(String userId, String password, String salt,
			String firstName, String lastName,Role role) {
		setUserId(userId);
		setPassword(password);
		setSalt(salt);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);

		friendList = new HashSet<Person>();
	}

	public Person() {
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}
	

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addFriend(Person newFriend){

		newFriend.addFriendOneWay(this);
		addFriendOneWay(newFriend);

	}

	public void addFriendOneWay(Person newFriend){

		if(newFriend == null) {

			throw new IllegalArgumentException("Incorrect Person given");
		}

		this.friendList.add(newFriend);
	}

	public boolean hasFriend(Person person){
		return hasFriend(person.getUserId());
	}

	public boolean hasFriend(String userid){

		for(Person p : this.getFriendList()){

			if(p.getUserId().equals(userid)){
				return true;
			}
		}

		return false;
	}

	public Collection<Person> getFriendList(){

		return this.friendList;
	}

	public void deleteFriend(String userid){
	    if(userid == null || userid.isEmpty()){

	        throw new IllegalArgumentException("Incorrect userid given");
        }


	    for(Person p: this.friendList){

	        if(p.getUserId().equals(userid)){

	            this.friendList.remove(p);
            }
        }
    }
}
