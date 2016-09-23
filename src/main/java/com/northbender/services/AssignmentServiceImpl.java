package com.northbender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.northbender.domain.Assignment;
import com.northbender.repositories.AssignmentRepository;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    @Autowired
    public void setAssignmentRepository(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
	public Iterable<Assignment> listAll() {
		return assignmentRepository.findAll();
	}

	@Override
	public Assignment getAssignmentById(Integer Id) {
		return assignmentRepository.findOne(Id);
	}

	@Override
	public Assignment saveAssignment(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

	@Override
	public void deleteAssignment(Integer Id) {
		assignmentRepository.delete(Id);
	}
}