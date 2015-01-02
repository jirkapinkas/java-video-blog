package com.java.vlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.vlog.entity.Poll;
import com.java.vlog.repository.PollRepository;

@Transactional
@Service
public class PollService {

	@Autowired
	private PollRepository pollRepository;

	public void save(int selectedValue) {
		List<Poll> polls = pollRepository.findAll();
		if (polls.size() == 0) {
			Poll newPoll = new Poll();
			pollRepository.saveAndFlush(newPoll);
			polls = pollRepository.findAll();
		}
		if (polls.size() > 1) {
			throw new UnsupportedOperationException("currently there can be only one poll!");
		}
		Poll managedPoll = polls.get(0);
		switch (selectedValue) {
		case 1:
			managedPoll.setAnswer1Count(managedPoll.getAnswer1Count() + 1);
			break;

		case 2:
			managedPoll.setAnswer2Count(managedPoll.getAnswer2Count() + 1);
			break;

		case 3:
			managedPoll.setAnswer3Count(managedPoll.getAnswer3Count() + 1);
			break;

		case 4:
			managedPoll.setAnswer4Count(managedPoll.getAnswer4Count() + 1);
			break;

		case 5:
			managedPoll.setAnswer5Count(managedPoll.getAnswer5Count() + 1);
			break;

		case 6:
			managedPoll.setAnswer6Count(managedPoll.getAnswer6Count() + 1);
			break;

		case 7:
			managedPoll.setAnswer7Count(managedPoll.getAnswer7Count() + 1);
			break;

		default:
			throw new UnsupportedOperationException("unknown answer!");
		}
	}
}
