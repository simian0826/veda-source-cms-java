package tech.veda.cms.biz.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizhiying
 */
@Data
public class Result<T> implements Serializable {

	private int code;
	private String message;
	private T data;


	public static<T> Result succ(T data){
		return succ(200, "Operate successfully", data);
	}

	public static<T> Result succ(int code, String msg, T data){
		Result r = new Result();
		r.setCode(code);
		r.setMessage(msg);
		r.setData(data);
		return r;
	}

	public static Result fail(String msg){
		return fail(400, msg, null);
	}

	public static<T> Result fail(String msg, T data){
		return fail(400, msg, data);
	}

	public static<T> Result fail(int code, String msg, T data){
		Result r = new Result();
		r.setCode(code);
		r.setMessage(msg);
		r.setData(data);

		return r;
	}


}
