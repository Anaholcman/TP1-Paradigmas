package Tp2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new MyQueue().isEmpty() );
  }
  
	
  @Test public void test02AddElementsToTheQueue() {
    assertFalse( new MyQueue().add( "Something" ).isEmpty() );
  }
  
  
  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", new MyQueue().add( "Something" ).head() );
  }
  
  
  @Test public void test04TakeRemovesElementsFromTheQueue() {
	MyQueue queue = new MyQueue().add( "Something" );
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }
  
  
  @Test public void test05TakeReturnsLastAddedObject() {
	MyQueue queue = new MyQueue();
    String addedObject = "Something";
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

 
  @Test public void test06QueueBehavesFIFO() {
	MyQueue queue = new MyQueue();
    String firstAddedObject = "First";
    String secondAddedObject = "Second";

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

 
  @Test public void test07HeadReturnsFirstAddedObject() {
	MyQueue queue = new MyQueue();
    String firstAddedObject = "First";

    queue.add( firstAddedObject );
    queue.add( "Second" );

    assertEquals( queue.head(), firstAddedObject );
  }

  /*
  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    MyQueue queue = new MyQueue();
    queue.add( "Something" );
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

 
  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new MyQueue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    MyQueue queue = new MyQueue();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    MyQueue queue = new MyQueue();
    queue.add( "Something" );
    queue.take();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    MyQueue queue = new MyQueue();
    try {
      queue.head();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }
*/
 
}