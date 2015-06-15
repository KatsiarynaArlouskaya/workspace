package com.epam.nb.logic;

import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;

public interface Command {
	Response execute(Request request);
}
