package com.Sprint2.app.person.member.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipTypeService {

    @Autowired
    NormalRepository normalRepository;

    @Autowired
    TrailRepository trailRepository;

    @Autowired
    OtherRepository otherRepository;


}
