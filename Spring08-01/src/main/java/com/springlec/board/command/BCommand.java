package com.springlec.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	
	void execute (Model model);
	//여기가 web이랑 틀려진다. Spring은 모델로 왓다갔다 하니까.

}
