import re
text = "almdrasa is your way to learn programming the right way. almdrasa badges motivate students to do more.\
almdrasa quizes help students practice on what they have learned through the course. almdrasa courses are one of a kind because they were made by professionals. almdrasa look and feel is one of a kind, almdrasa wishes you a good learning. thanks."

print(re.sub("almdrasa \w{3,}","almdrasa", text,3 ))