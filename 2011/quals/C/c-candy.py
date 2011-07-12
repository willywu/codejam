#! /usr/bin/python

f_in="C-large.in"
f_out="c-out.txt"

def do_puzzle(fp_in):
    N_candies = int(fp_in.readline())
    candies = map(int, fp_in.readline().split())
    val = 0
    for c in candies:
        val ^= c
    if (val != 0):
        return "NO"
    candies.sort()
    return sum(candies[1:])

if __name__ == "__main__":
    fp_in = open(f_in)
    fp_out = open(f_out, 'w')
    T = int(fp_in.readline())
    for i in range(T):
        ans = do_puzzle(fp_in)
        fp_out.write("Case #%s: %s\n" % (i+1, ans))
    fp_in.close()
    fp_out.close()
    
