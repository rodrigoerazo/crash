/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.crsh.shell;

public class CommandExecutionTestCase extends AbstractCommandTestCase {

  public void testFailure() throws Exception {
    Throwable t = assertEvalError("fail");
//    assertEquals(Exception.class, t.getClass());
  }

  public void testInvalid() throws Exception {
    assertUnknownCommand("invalid");
//    assertEquals(MultipleCompilationErrorsException.class, t.getClass());
  }

  public void testAggregateContent() throws Exception {
    assertEquals("foobar", assertOk("echo foo + echo bar"));
  }

  public void testKeepLastPipeContent() throws Exception {
    // Should it be bar instance of foobar ???
    assertEquals("foobar", assertOk("echo foo | echo bar"));
  }
}