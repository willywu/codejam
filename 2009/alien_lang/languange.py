def to_decimal(alien_num, alien_lang):
    radix = len(alien_lang)
    dec_num = 0
    for (i, char) in enumerate(alien_num):
        expon = len(alien_num)-i-1
        dec_num += pow(radix, expon)*alien_lang.index(char)
    return dec_num

def to_targ(dec_num, targ_lang):
    radix = len(targ_lang)
    targ_num = ""
    while dec_num>0:
        dec_num_remainder = dec_num % radix
        targ_num = targ_lang[dec_num_remainder] + targ_num
        dec_num = dec_num / radix
    return ''.join(targ_num)

if __name__=="__main__":
    #input = open("A-small-practice.in")
    input = open("A-large-practice.in")
    outfile = open("A-out.txt", 'w')
    n = int(input.readline())
    for i in range(n):
        al_num, al_lang, t_lang = input.readline().split()
        dec_num = to_decimal(al_num, al_lang)
        targ_num = to_targ(dec_num, t_lang)
        outfile.write("Case #%s: %s\n" % (i+1, targ_num))
    outfile.close()
