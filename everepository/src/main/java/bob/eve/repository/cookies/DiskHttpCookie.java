/*
 * Create by BobEve on 17-12-10 下午3:10
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 17-12-10 下午3:10
 */

package bob.eve.repository.cookies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpCookie;

/**
 * Created by Bob on 17/12/10.
 */

public class DiskHttpCookie implements Serializable {
	private static final long serialVersionUID = -5611769095642323514L;

	private transient final HttpCookie cookie;
	private transient HttpCookie clientCookie;

	public DiskHttpCookie(HttpCookie cookie) {
		this.cookie = cookie;
	}

	public HttpCookie getCookie() {
		HttpCookie cookie = this.cookie;
		if (clientCookie != null) {
			cookie = clientCookie;
		}

		return cookie;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(cookie.getName());
		oos.writeObject(cookie.getValue());
		oos.writeObject(cookie.getDomain());
		oos.writeObject(cookie.getPath());
		oos.writeLong(cookie.getMaxAge());
		oos.writeObject(cookie.getPortlist());
		oos.writeObject(cookie.getComment());
		oos.writeObject(cookie.getCommentURL());
		oos.writeBoolean(cookie.getDiscard());
		oos.writeBoolean(cookie.getSecure());
		oos.writeInt(cookie.getVersion());
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		String name = (String) ois.readObject();
		String value = (String) ois.readObject();
		clientCookie = new HttpCookie(name, value);

		clientCookie.setDomain((String) ois.readObject());
		clientCookie.setPath((String) ois.readObject());
		clientCookie.setMaxAge(ois.readLong());
		clientCookie.setPortlist((String) ois.readObject());
		clientCookie.setComment((String) ois.readObject());
		clientCookie.setCommentURL((String) ois.readObject());
		clientCookie.setDiscard(ois.readBoolean());
		clientCookie.setSecure(ois.readBoolean());
		clientCookie.setVersion(ois.readInt());
	}
}
