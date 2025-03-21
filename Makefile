JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
SOURCES = $(wildcard $(SRC_DIR)/*.java)
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)
MAIN_CLASS = Main
all: $(CLASSES)
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java | $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $<
$(BIN_DIR):
	mkdir -p $(BIN_DIR)
run: all
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)
clean:
	rm -rf $(BIN_DIR)
.PHONY: all run clean

