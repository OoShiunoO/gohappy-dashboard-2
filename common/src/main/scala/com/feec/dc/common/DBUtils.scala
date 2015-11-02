package com.feec.dc.common

import java.sql.{Connection, DriverManager}

import scala.util.control.NonFatal

/**
 * DB 操作相關的 functions
 */
object DBUtils {
  
  /**
   * Init Class for Loader
   */
  def initForClass(driver: String) = Class.forName(driver)
  
  /**
   * connect to database with uri, user, and passowrd
   */
  def connect(uri: String, user: String, password: String) = 
    DriverManager.getConnection(uri, user, password)
  
  
  /**
   * close AutoCloseable resource in silence
   */
  def close(resource: AutoCloseable) {
    if (resource != null) {
      try {
        resource.close()
      }
      catch {
        case NonFatal(ex) =>
      }
    }
  }

  /*
  private def name(sql: String, id: Long, conn: Connection) = {
    lazy val stmt = conn.prepareStatement(sql)
    lazy val rs = stmt.executeQuery()
    
    try {
      stmt.setLong(1, id)
      if (rs.next()) Some(rs.getString(1)) else None
    }
    catch {
      case NonFatal(ex) =>
        None
    }
    finally {
      DBUtils.close(rs)
      DBUtils.close(stmt)
    }  
  }


  private def nameReverse(sql: String, id: Long, conn: Connection): Array[String] = {
    lazy val stmt = conn.prepareStatement(sql)
    lazy val rs = stmt.executeQuery()
    
    try {
      stmt.setLong(1, id)
      if(rs.next()){
        Array(rs.getString("NAME"), rs.getString("PARENT_ID"))
      }else{
        Array.empty[String]
      }
    }catch {
      case NonFatal(ex) =>
        Array.empty[String]
    }finally {
      DBUtils.close(rs)
      DBUtils.close(stmt)
    }  
  }
  
  
  //def product(pid: Long, conn: Connection) = name("select NAME from EC_APUSER.PRD_PRODUCT_INFO where ID = ?", pid, conn)
  def product(pid: Long, conn: Connection) = name("select NAME from DM_EC.D_PRD_PRODUCT_INFO where ID = ?", pid, conn)
  
  //def category(cid:Long, conn: Connection) = name("select NAME from EC_APUSER.PRD_CATEGORY where ID = ?", cid, conn)
  def category(cid:Long, conn: Connection) = name("select NAME from DM_EC.D_PRD_CATEGORY where ID = ?", cid, conn)
  
  //def categoryReverse(cid:Long, conn: Connection) = nameReverse("select NAME, PARENT_ID from EC_APUSER.PRD_CATEGORY where ID = ?", cid, conn)
  def categoryReverse(cid:Long, conn: Connection) = nameReverse("select NAME, PARENT_ID from DM_EC.D_PRD_CATEGORY where ID = ?", cid, conn)
  */

}