package com.northbender.services;

import com.northbender.domain.Assignment;

public interface AssignmentService {
	Iterable<Assignment> listAll();
	Assignment getAssignmentById( Integer Id);
	Assignment saveAssignment( Assignment assignment);
	void deleteAssignment( Integer Id);
}
