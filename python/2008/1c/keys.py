in_handle = open("/Users/willywu/Desktop/A-large.in")
#in_handle = open("/Users/willywu/Desktop/test")

numTests = int(in_handle.readline())

for i in range(1, numTests+1):
    maxLetPerKey, numKeys, numLetters = in_handle.readline().split(" ")
    maxLetPerKey = int(maxLetPerKey)
    numKeys = int(numKeys)
    numLetters = int(numLetters)

    letterFreq = [int(x) for x in in_handle.readline().split(" ")]
    
    letterFreq.sort()

    numClicks = 0

    total = 0
    for m in range(maxLetPerKey):
    	numClicks += 1
    	for n in range(numKeys):
            if (len(letterFreq)==0):
                break
            total += numClicks*letterFreq.pop()

    print "Case #%s: %s" % (i, total)
