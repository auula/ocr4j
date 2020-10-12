package main

import (
	"flag"
	"fmt"
	"os"
	"strings"

	"github.com/otiai10/gosseract/v2"
)

var (
	data      string
	path      string
	languages []string
)

//定义一个类型，用于增加该类型方法
type sliceValue []string

//new一个存放命令行参数值的slice
func newSliceValue(vals []string, p *[]string) *sliceValue {
	*p = vals
	return (*sliceValue)(p)
}

/*
Value接口：
type Value interface {
    String() string
    Set(string) error
}
实现flag包中的Value接口，将命令行接收到的值用,分隔存到slice里
*/
func (s *sliceValue) Set(val string) error {
	*s = sliceValue(strings.Split(val, ","))
	return nil
}

//flag为slice的默认值default is me,和return返回值没有关系
func (s *sliceValue) String() string {
	*s = sliceValue(strings.Split("eng,chi_sim", ","))
	return "It's none of my business"
}

func init() {
	flag.StringVar(&data, "data", "/opt/tessdata", "Set tessdata path")
	flag.StringVar(&path, "path", "", "Set file path")
	flag.Var(newSliceValue([]string{}, &languages), "lang", "set languages agrs")
}

// ./ocr -data /Users/ding/Desktop/tessdata -path /Users/ding/Desktop/test.png -lang chi_sim
func main() {
	flag.Parse()
	os.Setenv("TESSDATA_PREFIX", data)
	client := gosseract.NewClient()
	client.Languages = languages
	defer client.Close()
	client.SetImage(path)
	text, _ := client.Text()
	fmt.Println(text)
}
