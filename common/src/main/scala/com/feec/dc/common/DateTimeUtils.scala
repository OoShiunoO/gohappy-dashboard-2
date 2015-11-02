package com.feec.dc.common

import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Try

object DateTimeUtils {
  
  val DateTimeFormat = "yyyy-MM-dd HH:mm:ss";
  val DateFormat = "yyyy-MM-dd";
  val TimeFormat = "HH:mm:ss";
  val DateTimeMinFormat = "yyyy-MM-dd HH:mm";
  
  def parse(value: String, pattern: String): Option[Date] = Try {
    val sdf = new SimpleDateFormat(pattern)
    sdf.parse(value)
  } toOption
  
  def parseDateTime(value: String, pattern: String = DateTimeFormat): Option[Date] = parse(value, pattern)
  
  def parseDate(value: String, pattern: String = DateFormat) = parse(value, pattern)
  
  def parseTime(value: String, pattern: String = TimeFormat) = parse(value, pattern)
  
  def parseMinTime(value: String, pattern: String = DateTimeMinFormat) = parse(value, pattern)
    
  def format(date: Date, pattern: String): Option[String] = Try {
    val sdf = new SimpleDateFormat(pattern)
    sdf.format(date)
  } toOption
  
  def format(timeInMillis: Long, pattern: String): Option[String] = format(new Date(timeInMillis), pattern)
  
  def formatDateTime(date: Date, pattern: String = DateTimeFormat): Option[String] = format(date, pattern)
  
  def formatDateMinTime(date: Date, pattern: String = DateTimeMinFormat) = format(date, pattern)
  
  //def formatDateTime(timeInMillis: Long, pattern: String = DATE_TIME_FORMAT): Option[String] = format(new Date(timeInMillis), pattern)
  
  def formatDate(date: Date, pattern: String = DateFormat) = format(date, pattern)
  
  //def formatDate(timeInMillis: Long, pattern: String = DATE_FORMAT) = format(new Date(timeInMillis), pattern)
  
}