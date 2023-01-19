package com.revature.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.poms.config.test.DatabaseConnectionTest;
import com.poms.dao.impl.test.AddQuestionTest;
import com.poms.dao.impl.test.DisplayDaoImplTest;
import com.poms.dao.impl.test.UserDaoImplTest;
@RunWith (Suite.class)
@Suite.SuiteClasses({DatabaseConnectionTest.class,AddQuestionTest.class,DisplayDaoImplTest.class,UserDaoImplTest.class})
public class TestSuite {

}
