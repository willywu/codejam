def run():
   for a in range(N):
      n, m, X, Y, Z = map(int, fp.readline().split(' '))
      A = [0]*m
      speed = []
      for j in range(m):
         A[j] = int(fp.readline())
      for j in range(n):
         speed.append(A[j%m])
         A[j % m] = (X * A[j % m] + Y * (j + 1)) % Z
      speeds[a] = speed

if __name__ == "__main__":
    #fp = open('/Users/willywu/Desktop/sample')
    fp = open('/Users/willywu/Desktop/C-large.in')
    N = int(fp.readline())
    speeds = {}

    run()
    
    case = 0
    for i in speeds:
        case += 1
        sp = speeds[i]
        le = len(sp)
        numCombos = [0 for i in range(le)]
        for j in range(le-1,-1,-1):
            # first add up all the contributions from the trailing speeds
            for k in range(j+1, le):
                if sp[j]<sp[k]:
                    numCombos[j] += numCombos[k]
                    numCombos[j] = numCombos[j]%1000000007
            # then add 1, because singleton is an increasing subset
            numCombos[j] += 1

        ans = sum(numCombos)%1000000007
        print "Case #%s: %s" % (case, ans)
    
