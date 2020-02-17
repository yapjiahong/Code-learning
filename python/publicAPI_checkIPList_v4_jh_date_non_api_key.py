#!/usr/bin/python

import re
import sys
import os.path
import time
import Queue
import multiprocessing
import json
import urllib
import pprint

def dumpQueue(queue):
	result = []
	for i in iter(queue.get, 'STOP'):
		result.append(i)
	return result

def checkIP(IP,publicAPIKey):
	# Check whether it is private IP
	# Private IP address range
	# 10.0.0.0 - 10.255.255.255
	# 172.16.0.0 - 172.31.255.255
	# 192.168.0.0 - 192.168.255.255
	IPsplit = IP.split(".")
	ip=str(IP)
	print(ip)
	if int(IPsplit[0]) == 10 :
		#return "Private IP"
		resultList.append(ip + "\tPrivate IP")

	elif (int(IPsplit[0]) == 172) and (16<= int(IPsplit[1]) <= 31) :
		#return "PrivateIP"
		resultList.append(ip + "\tPrivate IP")

	elif (int(IPsplit[0]) == 192) and ( int(IPsplit[1]) == 168) :
		#return "PrivateIP"
		resultList.append(ip + "\tPrivate IP")
		
	else :
		reputation = ""
		queryResult = {}
		total_date_and_time = ""
		dUrls = {}	#detected_urls
		dDS = {}	#detected_downloaded_samples
		dCS = {}	#detected_communicating_samples
		dRS = {}	#detected_referrer_samples
		ddate = {}	#collect all the url/samples detected date
		count_dUrls = 0	#detected_urls
		count_dDS = 0	#detected_downloaded_samples
		count_dCS = 0	#detected_communicating_samples
		count_dRS = 0	#detected_referrer_samples

		# Call virustotal Public API
		url = "https://www.virustotal.com/vtapi/v2/ip-address/report"
		parameters = {"ip": IP, "apikey": publicAPIKey}
		response = urllib.urlopen("%s?%s" % (url, urllib.urlencode(parameters))).read()

		if response == "" :	#Hit the limit request rate of 600/min or 50K/day
			#return IP + "\tHitLimit"
			#resultQueue.put(IP + "\tHitLimit")
			resultList.append(ip + "\tHitLimit")
			
		else :
			response_dict = json.loads(response)

			#if( response_dict["response_code"])
			# response_code == 1	:	item was indeed present and it could be retrieved
			# response_code == 0	:	No information regarding the IP address
			# response_code == -1	:	Submitted IP address is invalid
			# response_code == -2	:	requested item is still queued for analysis
			queryResult["RC"] = response_dict["response_code"]
			if response_dict["response_code"] == 1 : # Normal case 
				if "detected_urls" in response_dict :
					dUrls = response_dict["detected_urls"]
					count_dUrls = len(dUrls)
					queryResult["dUrls"] = count_dUrls
					# ddate = response_dict["detected_urls"]["scan_date"]
					# for scan_date in ddate:
					# countlenth = len(ddate)
					# print(countlenth)
					print("\n\tStart of test> detected_urls")
					print("lenth of durls> " + str(count_dUrls))
					datelenth = []
					for entity_of_url in dUrls:
						if "scan_date" in entity_of_url:
							possitves = entity_of_url["positives"]
							total = entity_of_url["total"]
							date = entity_of_url["scan_date"]
							debug_checkIP(possitves,total,date)
							total_date_and_time += ","+date
							datelenth.append(date)
					print("lenth of date>" + str(len(datelenth)))
					for show_lenth in datelenth:
						print(show_lenth)
					print("\n\tEnd of test> detected_urls")

				if "detected_downloaded_samples" in response_dict :
					dDS = response_dict["detected_downloaded_samples"]
					count_dDS = len(dDS)
					queryResult["dDS"] = count_dDS
					####
					print("\n\tStart of test> detected_downloaded_samples")
					print("lenth of durls> " + str(count_dDS))
					datelenth = []
					for entity_of_url in dDS:
						if  "date" in entity_of_url:
							possitves = entity_of_url["positives"]
							total = entity_of_url["total"]
							date = entity_of_url["date"]
							debug_checkIP(possitves,total,date)
							total_date_and_time += ","+date
							datelenth.append(date)
					print("lenth of date>" + str(len(datelenth)))
					for show_lenth in datelenth:
						print(show_lenth)
					print("\n\tEnd of test> detected_downloaded_samples")

				if "detected_communicating_samples" in response_dict :
					dCS = response_dict["detected_communicating_samples"]
					count_dCS = len(dCS)
					queryResult["dCS"] = count_dCS
					####
					print("\n\tStart of test> detected_communicating_samples")
					print("lenth of dCS> " + str(count_dCS))
					datelenth = []
					for entity_of_url in dCS:
						if "date" in entity_of_url:
							possitves = entity_of_url["positives"]
							total = entity_of_url["total"]
							date = entity_of_url["date"]
							debug_checkIP(possitves,total,date)
							total_date_and_time += ","+date
							datelenth.append(date)
					print("lenth of date>" + str(len(datelenth)))
					for show_lenth in datelenth:
						print(show_lenth)
					print("\n\tEnd of test> detected_communicating_samples")					

				if "detected_referrer_samples" in response_dict :
					dRS = response_dict["detected_referrer_samples"]
					count_dRS = len(dRS)
					queryResult["dRS"] = count_dRS
					####
					print("\n\tStart of test> detected_referrer_samples")
					print("lenth of dRS> " + str(count_dRS))
					datelenth = []
					for entity_of_url in dRS:
						if  "date" in entity_of_url:
							possitves = entity_of_url["positives"]
							total = entity_of_url["total"]
							date = entity_of_url["date"]
							debug_checkIP(possitves,total,date)
							total_date_and_time += ","+date
							datelenth.append(date)
					print("lenth of date>" + str(len(datelenth)))
					for show_lenth in datelenth:
						print(show_lenth)
					print("\n\tEnd of test> detected_referrer_samples")										

				if count_dUrls!=0 or count_dDS!=0 or count_dCS!=0 or count_dRS!=0 :
					reputation = "Malicious IP"
				else :
					reputation = "Legitimate IP"
			elif response_dict["response_code"] == 0 : 
				reputation = "Unknown IP"
			elif response_dict["response_code"] == -1 : 
				reputation = "Unknown IP"
			elif response_dict["response_code"] == -2 : 
				reputation = "Unknown IP"

			#return IP + "\t" + reputation + "\t" + str(queryResult)
			#resultQueue.put(IP + "\t" + reputation + "\t" + str(queryResult))
			ip_result =str(IP) + "\t" + reputation + "\t" + str(queryResult) +"\t"+ total_date_and_time
			print(ip_result)
			resultList.append(ip_result)

# global variable
UnCheckIPList = []
PrivateIPList = []

def debug_checkIP(possitves,total,date):
	print("possitves> "+str(possitves))
	print("total> "+str(total))
	print("Date> "+str(date))


# analyze result list
def analyzeResult ( malIPSet, unkIPSet, legIPSet ) :
	
	for result in resultList :
		
		tmpList = result.split("\t")
		
		if tmpList[1] == "HitLimit" :
			UnCheckIPList.append ( tmpList[0] )
		
		elif tmpList[1] == "Malicious IP" :
			tmp_IP_and_Date = tmpList[0] +"\t"+ tmpList[3]
			malIPSet.add( tmp_IP_and_Date ) # add IP in set
			
		elif tmpList[1] == "Unknown IP" :
			unkIPSet.add( tmpList[0] ) # add IP in set
			
		elif tmpList[1] == "Legitimate IP" :
			legIPSet.add( tmpList[0] ) # add IP in set
			
		else :
			PrivateIPList.append ( tmpList[0] )


# write checked IP sets to file
def writeToFile ( ipset, filename ) :
	
	if len ( ipset ) != 0 :
		fw = open ( filename, 'a' )
		for ip in ipset :
			fw.write ( ip + "\n" )
		fw.close()


"""
Parsing command line arguments
$ ./demo.py input.txt output.txt
sys.argv[0]=./demo.py
sys.argv[1]=input.txt
sys.argv[2]=output.txt
"""
start_time = time.time() # Record start time

publicAPIKey = "" #old key, hpdslab2

#resultList = []
resultList = []
count = 0
vt_max = 4

if len ( sys.argv ) == 3 :
	# check the output file exist or not
	if os.path.isfile (sys.argv[2]) : # File exist 
		print ( "Alread have the output file in the directory" )
	if os.path.isfile (sys.argv[2]+"_unCheckIPs") : # File exist 
		print ( "Alread have the output_unCheckIPs file in the directory" )
	else : #File not exist
		IPList = []
		with open ( sys.argv[1] ) as fr :
			for tmp in fr.readlines() :
				IPList.append ( tmp.rstrip("\n") ) # Remove \n
		
		# test
		print ( "IPList size = " + str (len(IPList)) )
		
		
		
		# sets to store already checked IP
		malIPSet = set()
		unkIPSet = set()
		legIPSet = set()
		
		
		# counter
		count = 0
		queryNum = 0
		pCount = 0  # process count
		

		# check IP list
		for ip in IPList :
			count = count + 1
			if count < vt_max :
				checkIP(ip,publicAPIKey)
				queryNum += 1	
			else:
				checkIP(ip,publicAPIKey)
				queryNum += 1
				analyzeResult (malIPSet, unkIPSet, legIPSet )
				print ( "queryNum = " + str(queryNum) )
				print ( "Execution Time : %s (s)" % (time.time() - start_time) )
				print ( "sleep 60 sec" )
				time.sleep(60)
				count = 0
				print("count> "+str(count))
				del resultList[:]
		
		print ( "sleep 60 sec" )
		time.sleep(60)
		analyzeResult (malIPSet, unkIPSet, legIPSet )
		print ( "queryNum = " + str(queryNum) )
		print ( "Execution Time : %s (s)" % (time.time() - start_time) )
		# print ( "sleep 60 sec" )
		#time.sleep(60)
		count = 0
		print("count> "+str(count))
		del resultList[:]
		
		writeToFile ( malIPSet, "malIPSet" )
		writeToFile ( unkIPSet, "unkIPSet" )
		writeToFile ( legIPSet, "legIPSet" )
		
		# test
		print ( "total queryNum = " + str(queryNum) )
		
		
		
		# If there are UnCheck IPs because of hit request limit -> write UnCheck IPs into file
		if len(UnCheckIPList)!=0 :
			fw2 = open(sys.argv[2]+"_unCheckIPs",'w')
			for ip in UnCheckIPList:
				fw2.write( ip + "\n")
			fw2.close()
		
		
	print ("Total Execution Time : %s (s)" % (time.time() - start_time))
	
else:
	print ("Usage: ./publicAPI_checkIPList.py input output")
	print ("Input format :\t218.65.30.61")
	print ("\t\t173.194.72.101")
	print ("\t\t140.116.164.72")
	print ("\t\t140.116.164.73")
