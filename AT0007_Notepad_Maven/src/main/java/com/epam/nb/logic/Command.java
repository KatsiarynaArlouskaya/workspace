package com.epam.nb.logic;

import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.LogicException;

public interface Command {
	Response execute(Request request) throws LogicException;
}
