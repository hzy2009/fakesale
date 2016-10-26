package com.mcoding.buyw.fakesale.service;

import com.mcoding.buyw.fakesale.bean.Member;

public interface Command {

	Object excute(Member member) throws Exception;

}
