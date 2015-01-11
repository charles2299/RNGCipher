SRCS := $(wildcard *.java)

STYLEPROG = style61b

JFLAGS = -g -Xlint:unchecked

default: sentinel

style: default
		$(STYLEPROG) $(SRCS)

sentinel: $(SRCS)
				javac $(SRCS)
				touch sentinel

check: sentinel
				java CipherTest

